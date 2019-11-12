package top.lsmod.lmmodels;

import top.lsmod.lmmodels.bean.TestNetWorkBean;
import top.lsmod.uimodel.FlBaseActivity;
import top.lsmod.uimodel.base.FlBaseInterfaceReqBean;
import top.lsmod.uimodel.base.FlBaseInterfaceRspBean;

public class MainActivity extends FlBaseActivity {

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        TestNetWorkBean testNetWorkBean = new TestNetWorkBean();
        testNetWorkBean.setCode("utf-8");
        testNetWorkBean.setQ("24k");
        sendRequest(BuildConfig.DEMO_INTERFACE, new FlBaseInterfaceReqBean(InterfaceNetWorks.TestTaoBao, testNetWorkBean));
    }

    @Override
    public void onNetWorkResponse(FlBaseInterfaceRspBean interfaceRspBean) {
        super.onNetWorkResponse(interfaceRspBean);
        if (interfaceRspBean.getInterfaceId() == (int) InterfaceNetWorks.TestTaoBao[1]) {
            showToast(interfaceRspBean.getHttpResult());
        }
    }
}
