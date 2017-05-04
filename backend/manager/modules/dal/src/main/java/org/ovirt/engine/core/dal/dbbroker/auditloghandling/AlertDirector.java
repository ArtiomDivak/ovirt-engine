package org.ovirt.engine.core.dal.dbbroker.auditloghandling;

import org.ovirt.engine.core.common.AuditLogType;
import org.ovirt.engine.core.compat.Guid;
import org.ovirt.engine.core.dal.dbbroker.DbFacade;

/**
 * AlertDirector
 */
public final class AlertDirector {

    /**
     * Removes the alert.
     *
     * @param vdsId
     *            The VDS id.
     * @param type
     *            The type.
     */
    public static void removeVdsAlert(Guid vdsId, AuditLogType type) {
        DbFacade.getInstance().getAuditLogDao().removeAllOfTypeForVds(vdsId, type.getValue());
    }

    /**
     * Removes the alert
     * @param volumeId
     *            The volume id
     * @param type
     *            The alert type
     */
    public static void removeVolumeAlert(Guid volumeId, AuditLogType type) {
        DbFacade.getInstance().getAuditLogDao().removeAllOfTypeForVolume(volumeId, type.getValue());
    }

    /**
     * Removes all alerts.
     *
     * @param vdsId
     *            The VDS id.
     * @param removeConfigAlerts
     *            if set to <c>true</c> [remove config alerts].
     */
    public static void removeAllVdsAlerts(Guid vdsId, boolean removeConfigAlerts) {
        DbFacade.getInstance().getAuditLogDao().removeAllForVds(vdsId, removeConfigAlerts);
    }

    /**
     * Removes the brick down alert.
     *
     * @param vdsId
     *            The VDS id.
     * @param type
     *            The type.
     */
    public static void removeAlertsByBrickIdLogType(Guid brickId, AuditLogType logtype) {
        DbFacade.getInstance().getAuditLogDao().removeAllofTypeForBrick(brickId, logtype.getValue());
    }
}
