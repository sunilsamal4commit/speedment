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
package com.speedment.tool.config;

import com.speedment.runtime.Speedment;
import com.speedment.runtime.annotation.Api;
import com.speedment.tool.component.DocumentPropertyComponent;
import com.speedment.runtime.config.ForeignKey;
import com.speedment.runtime.config.Table;
import com.speedment.tool.config.mutator.DocumentPropertyMutator;
import com.speedment.tool.config.mutator.ForeignKeyPropertyMutator;
import static com.speedment.runtime.internal.util.ImmutableListUtil.*;
import com.speedment.tool.config.trait.HasEnabledProperty;
import com.speedment.tool.config.trait.HasExpandedProperty;
import com.speedment.tool.config.trait.HasNameProperty;
import java.util.List;
import java.util.stream.Stream;
import javafx.collections.ObservableList;
import org.controlsfx.control.PropertySheet;

/**
 *
 * @author  Emil Forslund
 * @since   2.3.0
 */
@Api(version = "3.0")
public final class ForeignKeyProperty extends AbstractChildDocumentProperty<Table, ForeignKeyProperty> 
    implements ForeignKey, HasEnabledProperty, HasExpandedProperty, HasNameProperty {

    public ForeignKeyProperty(Table parent) {
        super(parent);
    }
    
    public ObservableList<ForeignKeyColumnProperty> foreignKeyColumnsProperty() {
        return observableListOf(FOREIGN_KEY_COLUMNS);
    }
    
    @Override
    public Stream<ForeignKeyColumnProperty> foreignKeyColumns() {
        return foreignKeyColumnsProperty().stream();
    }

    @Override
    public boolean isExpandedByDefault() {
        return false;
    }
    
    @Override
    public ForeignKeyPropertyMutator mutator() {
        return DocumentPropertyMutator.of(this);
    }
    
    @Override
    public Stream<PropertySheet.Item> getUiVisibleProperties(Speedment speedment) {
        return Stream.concat(
            HasEnabledProperty.super.getUiVisibleProperties(speedment),
            HasNameProperty.super.getUiVisibleProperties(speedment)
        );
    }
    
    @Override
    protected List<String> keyPathEndingWith(String key) {
        return concat(DocumentPropertyComponent.FOREIGN_KEYS, key);
    }
}