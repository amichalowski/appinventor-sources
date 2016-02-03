package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;

/**
 * Created by belgarion on 27.01.16.
 */

@DesignerComponent(version = 1,
        description = "<p>test description</p>",
        category = ComponentCategory.EXPERIMENTAL,
        nonVisible = true,
        iconName = "images/timer.png")
@SimpleObject

public class Timer extends AndroidNonvisibleComponent {
    /**
     * Creates a new AndroidNonvisibleComponent.
     *
     * @param form the container that this component will be placed in
     */
    protected Timer(Form form) {
        super(form);
    }
}
