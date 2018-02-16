/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package com.facebook.react.uimanager;

import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.events.TouchEventType;
import java.util.Map;


/**
 * Constants exposed to JS from {@link UIManagerModule}.
 */
/* package */ class UIManagerModuleConstants {

  public static final String ACTION_DISMISSED = "dismissed";
  public static final String ACTION_ITEM_SELECTED = "itemSelected";

  /* package */ static Map getBubblingEventTypeConstants() {
    return MapBuilder.builder()
        .put(
            "topChange",
            MapBuilder.of(
                "phasedRegistrationNames",
                MapBuilder.of("bubbled", "onChange", "captured", "onChangeCapture")))
        .put(
            "topSelect",
            MapBuilder.of(
                "phasedRegistrationNames",
                MapBuilder.of("bubbled", "onSelect", "captured", "onSelectCapture")))
        .put(
            TouchEventType.START.getJSEventName(),
            MapBuilder.of(
                "phasedRegistrationNames",
                MapBuilder.of(
                    "bubbled",
                    "onTouchStart",
                    "captured",
                    "onTouchStartCapture")))
        .put(
            TouchEventType.MOVE.getJSEventName(),
            MapBuilder.of(
                "phasedRegistrationNames",
                MapBuilder.of(
                    "bubbled",
                    "onTouchMove",
                    "captured",
                    "onTouchMoveCapture")))
        .put(
            TouchEventType.END.getJSEventName(),
            MapBuilder.of(
                "phasedRegistrationNames",
                MapBuilder.of(
                    "bubbled",
                    "onTouchEnd",
                    "captured",
                    "onTouchEndCapture")))
        .put(
            TouchEventType.CANCEL.getJSEventName(),
            MapBuilder.of(
                "phasedRegistrationNames",
                MapBuilder.of(
                    "bubbled",
                    "onTouchCancel",
                    "captured",
                    "onTouchCancelCapture")))
        .build();
  }

  /* package */ static Map getDirectEventTypeConstants() {
    final String rn = "registrationName";
    return MapBuilder.builder()
        .put("topContentSizeChange", MapBuilder.of(rn, "onContentSizeChange"))
        .put("topLayout", MapBuilder.of(rn, "onLayout"))
        .put("topLoadingError", MapBuilder.of(rn, "onLoadingError"))
        .put("topLoadingFinish", MapBuilder.of(rn, "onLoadingFinish"))
        .put("topLoadingStart", MapBuilder.of(rn, "onLoadingStart"))
        .put("topSelectionChange", MapBuilder.of(rn, "onSelectionChange"))
        .put("topMessage", MapBuilder.of(rn, "onMessage"))
        // Scroll events are added as per task T22348735.
        // Subject for further improvement.
        .put("topScrollBeginDrag", MapBuilder.of(rn, "onScrollBeginDrag"))
        .put("topScrollEndDrag", MapBuilder.of(rn, "onScrollEndDrag"))
        .put("topScroll", MapBuilder.of(rn, "onScroll"))
        .put("topMomentumScrollBegin", MapBuilder.of(rn, "onMomentumScrollBegin"))
        .put("topMomentumScrollEnd", MapBuilder.of(rn, "onMomentumScrollEnd"))
        // Scroll event for WebViews.
        .put("onScrollChanged", MapBuilder.of(rn, "onScrollChanged"))
        .build();
  }

  public static Map<String, Object> getConstants() {
    Map<String, Object> constants = MapBuilder.newHashMap();
    constants.put(
        "UIView",
        MapBuilder.of(
            "ContentMode",
            MapBuilder.of(
                "ScaleAspectFit",
                ImageView.ScaleType.FIT_CENTER.ordinal(),
                "ScaleAspectFill",
                ImageView.ScaleType.CENTER_CROP.ordinal(),
                "ScaleAspectCenter",
                ImageView.ScaleType.CENTER_INSIDE.ordinal())));

    constants.put(
        "StyleConstants",
        MapBuilder.of(
            "PointerEventsValues",
            MapBuilder.of(
                "none",
                PointerEvents.NONE.ordinal(),
                "boxNone",
                PointerEvents.BOX_NONE.ordinal(),
                "boxOnly",
                PointerEvents.BOX_ONLY.ordinal(),
                "unspecified",
                PointerEvents.AUTO.ordinal())));

    constants.put(
        "PopupMenu",
        MapBuilder.of(
            ACTION_DISMISSED,
            ACTION_DISMISSED,
            ACTION_ITEM_SELECTED,
            ACTION_ITEM_SELECTED));

    constants.put(
      "AccessibilityEventTypes",
      MapBuilder.of(
          "typeWindowStateChanged",
          AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED,
          "typeViewClicked",
          AccessibilityEvent.TYPE_VIEW_CLICKED));

    return constants;
  }
}
