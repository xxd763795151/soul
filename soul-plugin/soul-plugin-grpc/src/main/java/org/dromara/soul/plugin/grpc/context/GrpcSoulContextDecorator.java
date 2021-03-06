/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.soul.plugin.grpc.context;

import org.dromara.soul.common.dto.MetaData;
import org.dromara.soul.common.enums.RpcTypeEnum;
import org.dromara.soul.plugin.api.context.SoulContext;
import org.dromara.soul.plugin.api.context.SoulContextDecorator;

/**
 * The type Grpc soul context decorator.
 * 
 * @author xiaoyu
 */
public class GrpcSoulContextDecorator implements SoulContextDecorator {
    
    @Override
    public SoulContext decorator(final SoulContext soulContext, final MetaData metaData) {
        soulContext.setModule(metaData.getAppName());
        soulContext.setMethod(metaData.getServiceName());
        soulContext.setRpcType(metaData.getRpcType());
        soulContext.setContextPath(metaData.getContextPath());
        soulContext.setRpcType(RpcTypeEnum.GRPC.getName());
        return soulContext;
    }
    
    @Override
    public String rpcType() {
        return RpcTypeEnum.GRPC.getName();
    }
}
