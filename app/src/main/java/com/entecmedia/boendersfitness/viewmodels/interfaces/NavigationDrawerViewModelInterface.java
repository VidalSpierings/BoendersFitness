package com.entecmedia.boendersfitness.viewmodels.interfaces;

public interface NavigationDrawerViewModelInterface {

    void initActivity();

    void openOrCloseDrawer();

    void setNavItemOnClickListener();

    void initToolbar();

    void initLayoutForFoldableDevices();

    void removeWindowLayoutListener();
}
