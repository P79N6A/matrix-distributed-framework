/*
 *  Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.matrix.session;

import com.alibaba.fescar.core.exception.TransactionException;
import com.alibaba.fescar.core.model.BranchStatus;
import com.alibaba.fescar.core.model.GlobalStatus;

import java.util.Collection;
import java.util.List;

/**
 * The interface Session manager.
 */
public interface SessionManager extends SessionLifecycleListener {

    /**
     * Add global session.
     *
     * @param session the session
     * @throws TransactionException the transaction exception
     */
    void addGlobalSession(GlobalSession session) throws TransactionException;

    /**
     * Find global session global session.
     *
     * @param transactionId the transaction id
     * @return the global session
     * @throws TransactionException the transaction exception
     */
    GlobalSession findGlobalSession(Long transactionId) throws TransactionException;

    /**
     * Update global session status.
     *
     * @param session the session
     * @param status  the status
     * @throws TransactionException the transaction exception
     */
    void updateGlobalSessionStatus(GlobalSession session, GlobalStatus status) throws TransactionException;

    /**
     * Remove global session.
     *
     * @param session the session
     * @throws TransactionException the transaction exception
     */
    void removeGlobalSession(GlobalSession session) throws TransactionException;

    /**
     * Add branch session.
     *
     * @param globalSession the global session
     * @param session       the session
     * @throws TransactionException the transaction exception
     */
    void addBranchSession(GlobalSession globalSession, BranchSession session) throws TransactionException;

    /**
     * Update branch session status.
     *
     * @param session the session
     * @param status  the status
     * @throws TransactionException the transaction exception
     */
    void updateBranchSessionStatus(BranchSession session, BranchStatus status) throws TransactionException;

    /**
     * Remove branch session.
     *
     * @param globalSession the global session
     * @param session       the session
     * @throws TransactionException the transaction exception
     */
    void removeBranchSession(GlobalSession globalSession, BranchSession session) throws TransactionException;

    /**
     * All sessions collection.
     *
     * @return the collection
     */
    Collection<GlobalSession> allSessions();

    /**
     * Find global sessions list.
     *
     * @param condition the condition
     * @return the list
     */
    List<GlobalSession> findGlobalSessions(SessionCondition condition);


}
