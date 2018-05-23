/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

#import "AppDelegate.h"

//#import <WebDriverAgentLib/FBDebugLogDelegateDecorator.h>
//#import <WebDriverAgentLib/FBConfiguration.h>
//#import <WebDriverAgentLib/FBFailureProofTestCase.h>
#import <WebDriverAgentLib/FBWebServer.h>

@interface AppDelegate ()

@property (nonatomic, assign) UIBackgroundTaskIdentifier bgTask;
@property (nonatomic, assign) NSTimer *timer;

@end

@implementation AppDelegate

- (void)applicationDidFinishLaunching:(UIApplication *)application {
//  [FBDebugLogDelegateDecorator decorateXCTestLogger];
//  [FBConfiguration disableRemoteQueryEvaluation];

  FBWebServer *webServer = [[FBWebServer alloc] init];
  [webServer startServing];
}

-(void)applicationDidEnterBackground:(UIApplication *)application{
  [ self comeToBackgroundMode];
}

-(void)comeToBackgroundMode{
  //初始化一个后台任务BackgroundTask，这个后台任务的作用就是告诉系统当前app在后台有任务处理，需要时间
  UIApplication*  app = [UIApplication sharedApplication];
  self.bgTask = [app beginBackgroundTaskWithExpirationHandler:^{
    [app endBackgroundTask:self.bgTask];
    self.bgTask = UIBackgroundTaskInvalid;
  }];
  //开启定时器 不断向系统请求后台任务执行的时间
  self.timer = [NSTimer scheduledTimerWithTimeInterval:25.0 target:self selector:@selector(applyForMoreTime) userInfo:nil repeats:YES];
  [self.timer fire];
}

-(void)applyForMoreTime {
  //如果系统给的剩余时间小于60秒 就终止当前的后台任务，再重新初始化一个后台任务，重新让系统分配时间，这样一直循环下去，保持APP在后台一直处于active状态。
  if ([UIApplication sharedApplication].backgroundTimeRemaining < 60) {
    [[UIApplication sharedApplication] endBackgroundTask:self.bgTask];
    self.bgTask = [[UIApplication sharedApplication] beginBackgroundTaskWithExpirationHandler:^{
      [[UIApplication sharedApplication] endBackgroundTask:self.bgTask];
      self.bgTask = UIBackgroundTaskInvalid;
    }];
  }
}

@end
