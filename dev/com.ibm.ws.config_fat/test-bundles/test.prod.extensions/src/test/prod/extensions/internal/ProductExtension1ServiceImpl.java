/*******************************************************************************
 * Copyright (c) 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package test.prod.extensions.internal;

import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

import test.prod.extensions.ProductExtension1;

/**
 * Product Extension Service.
 */
public class ProductExtension1ServiceImpl implements ProductExtension1 {

    Long attribute1;
    String attribute2;

    /**
     * Declarative Services method to deactivate this component.
     * Best practice: this should be a protected method, not public or private
     * 
     * @param context context for this component
     */
    protected void activate(BundleContext bundleContext, Map<String, Object> properties) {
        System.out.println("@ed: attributeMap: " + properties.size());

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        attribute1 = (Long) properties.get("attribute1");
        System.out.println("@ed: attribute1: " + attribute1);
        attribute2 = (String) properties.get("attribute2");
        System.out.println("@ed: attribute2: " + attribute2);
    }

    /**
     * Declarative Services method to deactivate this component.
     * Best practice: this should be a protected method, not public or private
     * 
     * @param context context for this component
     */
    protected void deactivate(ComponentContext context) {}

    /*
     * (non-Javadoc)
     * 
     * @see test.prod.extensions.Product1#sayHello(java.lang.String)
     */
    @Override
    public String sayHello(String input) {
        return "you.said." + input + ".i.say." + input + ".back";
    }

    /*
     * (non-Javadoc)
     * 
     * @see test.prod.extensions.Product1#getAttribute1()
     */
    @Override
    public Long getAttribute1() {
        return attribute1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see test.prod.extensions.Product1#getAttribute1()
     */
    @Override
    public String getAttribute2() {
        return attribute2;
    }
}
