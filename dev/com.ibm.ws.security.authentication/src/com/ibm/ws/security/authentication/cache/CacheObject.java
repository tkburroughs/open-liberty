/*******************************************************************************
 * Copyright (c) 2011, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.security.authentication.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.security.auth.Subject;

/**
 * The cache object contains the subject to be placed on the cache as well as the keys used to cache.
 */
public class CacheObject implements Serializable {

    private static final long serialVersionUID = -2299564519252837462L;

    private final Subject subject;

    private final List<Object> lookupKeys = Collections.synchronizedList(new ArrayList<Object>(8));

    public CacheObject(Subject subject) {
        this.subject = subject;
    }

    /**
     * Add a lookup key to the {@link CacheObject}.
     *
     * <p/>
     * Warning! Calling this method will not change the lookup keys in a distributed cache
     * when this object is retrieved from the distributed cache. In this scenario, the instance
     * will need to be re-inserted into the distributed cache for the updates to take effect.
     *
     * @param key The lookup key to add.
     */
    public void addLookupKey(Object key) {
        if (key != null) {
            lookupKeys.add(key);
        }
    }

    /**
     * IMPORTANT: It is imperative that the user manually synchronize on the returned list
     * (using the synchronized block) when iterating over it . Failure to follow this
     * advice may result in non-deterministic behavior.
     *
     * @return the unmodifiable list of lookup keys in the cache object
     */
    public List<Object> getLookupKeys() {
        return Collections.unmodifiableList(lookupKeys);
    }

    public Subject getSubject() {
        return this.subject;
    }
}