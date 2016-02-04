package com.google.appinventor.components.runtime;

import android.app.Activity;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.util.AsynchUtil;

/**
 * Created by belgarion on 27.01.16.
 */

@DesignerComponent(version = 3,
        description = "<p>test description</p>",
        category = ComponentCategory.EXPERIMENTAL,
        nonVisible = true,
        iconName = "images/timer.png")
@SimpleObject

public class Timer extends AndroidNonvisibleComponent {
    /**
     * Creates a new AndroidNonvisibleComponent.
     *
     * @param container the container that this component will be placed in
     */
    private final Activity activity;

    public Timer(ComponentContainer container) {
        super(container.$form());
        activity = container.$context();
    }

    @SimpleProperty(
            category = PropertyCategory.BEHAVIOR,
            description = "Time")
    public int CountdownTime() {
        return time;
    }

    @DesignerProperty(
            editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
            defaultValue = "1000")
    @SimpleProperty
    public void CountdownTime(int time) {
        this.time = time;
    }

    @SimpleFunction(description = "start timer")
    public void Start() {
        final int localTime = time;
        AsynchUtil.runAsynchronously(new Runnable() {
                                         @Override
                                         public void run() {
                                             try {
                                                 Thread.sleep(localTime);
                                             } catch (InterruptedException e) {
                                                 e.printStackTrace();
                                             }
                                             activity.runOnUiThread(new Runnable() {
                                                 @Override
                                                 public void run() {
                                                     Fire();
                                                 }
                                             });
                                         }
                                     }

        );
    }

    @SimpleEvent(description = "fire")
    public void Fire() {
        EventDispatcher.dispatchEvent(this, "Fire");
    }

    private int time = 1000;
}
