package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import java.util.List;

import org.ovirt.engine.core.common.businessentities.StoragePool;
import org.ovirt.engine.ui.common.place.PlaceRequestFactory;
import org.ovirt.engine.ui.common.presenter.OvirtBreadCrumbsPresenterWidget;
import org.ovirt.engine.ui.common.uicommon.model.GroupedTabData;
import org.ovirt.engine.ui.common.uicommon.model.MainModelProvider;
import org.ovirt.engine.ui.uicommonweb.models.datacenters.DataCenterListModel;
import org.ovirt.engine.ui.uicommonweb.place.WebAdminApplicationPlaces;
import org.ovirt.engine.ui.webadmin.section.main.presenter.AbstractMainTabWithDetailsPresenter;
import org.ovirt.engine.ui.webadmin.section.main.presenter.MainTabPanelPresenter;
import org.ovirt.engine.ui.webadmin.section.main.presenter.SearchPanelPresenterWidget;
import org.ovirt.engine.ui.webadmin.widget.tab.MenuLayoutMenuDetails;
import org.ovirt.engine.ui.webadmin.widget.tab.WebadminMenuLayout;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.annotation.GenEvent;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class MainTabDataCenterPresenter extends AbstractMainTabWithDetailsPresenter<StoragePool,
    DataCenterListModel, MainTabDataCenterPresenter.ViewDef, MainTabDataCenterPresenter.ProxyDef> {

    @GenEvent
    public class DataCenterSelectionChange {

        List<StoragePool> selectedItems;

    }

    @ProxyCodeSplit
    @NameToken(WebAdminApplicationPlaces.dataCenterMainTabPlace)
    public interface ProxyDef extends TabContentProxyPlace<MainTabDataCenterPresenter> {
    }

    public interface ViewDef extends AbstractMainTabWithDetailsPresenter.ViewDef<StoragePool> {
    }

    @TabInfo(container = MainTabPanelPresenter.class)
    static TabData getTabData(WebadminMenuLayout menuLayout) {
        MenuLayoutMenuDetails menuTabDetails =
                menuLayout.getDetails(WebAdminApplicationPlaces.dataCenterMainTabPlace);
        return new GroupedTabData(
                menuTabDetails.getSecondaryTitle(),
                menuTabDetails.getPrimaryTitle(),
                menuTabDetails.getSecondaryPriority(),
                menuTabDetails.getPrimaryPriority(),
                menuTabDetails.getIcon());
    }

    @Inject
    public MainTabDataCenterPresenter(EventBus eventBus, ViewDef view, ProxyDef proxy,
            PlaceManager placeManager, MainModelProvider<StoragePool, DataCenterListModel> modelProvider,
            SearchPanelPresenterWidget<StoragePool, DataCenterListModel> searchPanelPresenterWidget,
            OvirtBreadCrumbsPresenterWidget<StoragePool, DataCenterListModel> breadCrumbs) {
        super(eventBus, view, proxy, placeManager, modelProvider, searchPanelPresenterWidget, breadCrumbs);
    }

    @Override
    protected void fireTableSelectionChangeEvent() {
        DataCenterSelectionChangeEvent.fire(this, getSelectedItems());
    }

    @Override
    protected PlaceRequest getMainTabRequest() {
        return PlaceRequestFactory.get(WebAdminApplicationPlaces.dataCenterMainTabPlace);
    }

}
