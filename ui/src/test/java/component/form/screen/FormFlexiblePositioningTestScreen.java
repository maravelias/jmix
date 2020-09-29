/*
 * Copyright 2020 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package component.form.screen;

import io.jmix.ui.UiComponents;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.Form;
import io.jmix.ui.component.TextArea;
import io.jmix.ui.component.TextField;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiDescriptor("form-flexible-positioning-test-screen.xml")
@UiController
public class FormFlexiblePositioningTestScreen extends Screen {

    @Autowired
    private Form form;

    @Autowired
    private UiComponents uiComponents;

    @Subscribe
    private void onInit(InitEvent event) {
        TextArea<String> textArea01 = uiComponents.create(TextArea.TYPE_STRING);
        textArea01.setId("component01");
        textArea01.setCaption("[P] TextArea [0, 1] - [0, 3]");
        textArea01.setSizeFull();
        form.add(textArea01, 0, 1, 3);

        TextField<String> textField11 = uiComponents.create(TextField.TYPE_STRING);
        textField11.setId("component11");
        textField11.setCaption("[P] TextField [1, 1] - [2, 1]");
        textField11.setWidthFull();
        form.add(textField11, 1, 1, 2, 1);

        TextField<String> textField13 = uiComponents.create(TextField.TYPE_STRING);
        textField13.setId("component13");
        textField13.setCaption("[P] TextField [1, 3] - [1, 3]");
        textField13.setWidthFull();
        form.add(textField13, 1);
    }

    public Component getFormComponent(int col, int row) {
        return form.getComponent(col, row);
    }

    public void addComponentToForm(Component component, int col, Integer row) {
        if (row != null) {
            form.add(component, col, row);
        } else {
            form.add(component, col);
        }
    }
}
