package org.ovirt.engine.core.common.vdscommands;

import org.ovirt.engine.core.compat.*;

public class HSMGetStorageDomainInfoVDSCommandParameters extends ValidateStorageDomainVDSCommandParameters {
    public HSMGetStorageDomainInfoVDSCommandParameters(Guid vdsId, Guid storageDomainId) {
        super(vdsId, storageDomainId);
    }

    public HSMGetStorageDomainInfoVDSCommandParameters() {
    }
}
