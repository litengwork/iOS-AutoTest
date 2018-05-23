# -*- coding: utf-8 -*-
import random

import wda
import os
import time
USERNAME = 'admin'
PASSWORD = '123456'
HELLO = 'こんにちは'
bundle_id = 'com.liteng.AppiuTestDemo'
c = wda.Client('http://0.0.0.0:8100')
s = c.session(bundle_id)
# def alert_callback(session):
#     btns = set([u'不再提醒', 'OK', u'知道了', 'Allow', u'允许']).intersection(c.session.alert.buttons())
# if len(btns) == 0:
#     raise RuntimeError("Alert can not handled, buttons: " + ', '.join(c.session.alert.buttons()))
# c.session.alert.click(list(btns)[0])
# s.set_alert_callback(alert_callback)
screenshot_backup_dir = 'screenshot_backups/'
if not os.path.isdir(screenshot_backup_dir):
    os.mkdir(screenshot_backup_dir)

def test_index(s):
    # time.sleep(1)
    # s(name=u'Confirm', type='Button').tap()
    s(type='TextField', value='username').set_text(USERNAME)
    s(type='SecureTextField', value='password').set_text(PASSWORD)
    s(name=u'Confirm', type='Button').tap()
    # s.alert.click("确定")
    s(name=u'Login', type='Button').tap()
    s(type='TextField', value='username').set_text(USERNAME)
    s(type='SecureTextField', value='password').set_text(PASSWORD)
    s(name=u'Confirm', type='Button').tap()
    for i in "abc":
        s(name=u'Page migration', type='Button').tap()
        s(name=u'Home', type='Button').tap()


    s(name=u'Other', type='Button').tap()
    s(type='TextField', value='helloworld').set_text(HELLO)
    s(name=u'Send', type='Button').tap()
    time.sleep(1)
    s(name=u'Home', type='Button').tap()
    s(name=u'Login', type='Button').tap()

    time.sleep(random.uniform(1, 1.1))
    c.screenshot('{}{}_d.png'.format(screenshot_backup_dir,HELLO))


test_index(s)

