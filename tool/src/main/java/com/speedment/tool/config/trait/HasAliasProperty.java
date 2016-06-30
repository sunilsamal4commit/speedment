/**
 *
 * Copyright (c) 2006-2016, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.tool.config.trait;

import com.speedment.runtime.config.trait.HasAlias;
import com.speedment.runtime.Speedment;
import com.speedment.runtime.annotation.Api;
import com.speedment.tool.config.DocumentProperty;
import com.speedment.tool.property.DefaultStringPropertyItem;
import java.util.Optional;
import java.util.stream.Stream;
import javafx.beans.property.StringProperty;
import org.controlsfx.control.PropertySheet;

/**
 *
 * @author  Emil Forslund
 * @since   2.3.0
 */
@Api(version = "3.0")
public interface HasAliasProperty extends DocumentProperty, HasAlias {

    StringProperty nameProperty();
    
    default StringProperty aliasProperty() {
        return stringPropertyOf(HasAlias.ALIAS, () -> null);
    }
    
    @Override
    default Optional<String> getAlias() {
        return Optional.ofNullable(aliasProperty().get());
    }

    @Override
    default Stream<PropertySheet.Item> getUiVisibleProperties(Speedment speedment) {
        return Stream.of(new DefaultStringPropertyItem(
                aliasProperty(),
                nameProperty(),
                "Java Alias", 
                "The name that will be used for this in generated code."
            )
        );
    }
}