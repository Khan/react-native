/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package com.facebook.react.views.webview.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Event emitted when a WebView has been scrolled.
 */
public class OnScrollChangedEvent extends Event<OnScrollChangedEvent> {

  public static final String EVENT_NAME = "onScrollChanged";

  private final int mL;
  private final int mT;
  private final int mOldl;
  private final int mOldt;

  public OnScrollChangedEvent(int viewId, int l, int t, int oldl, int oldt) {
    super(viewId);
    mL = l;
    mT = t;
    mOldl = oldl;
    mOldt = oldt;
  }

  @Override
  public String getEventName() {
    return EVENT_NAME;
  }

  @Override
  public void dispatch(RCTEventEmitter rctEventEmitter) {
    WritableMap data = Arguments.createMap();
    data.putInt("l", mL);
    data.putInt("t", mT);
    data.putInt("oldl", mOldl);
    data.putInt("oldt", mOldt);
    rctEventEmitter.receiveEvent(getViewTag(), EVENT_NAME, data);
  }
}
