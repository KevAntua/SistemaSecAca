package mx.ipn.upiicsa.udi.scasa.controller;

import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.service.ICtlgDtllEntrdAlmcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class CtrlDtllEntrAlmcnCtrller {
    
    @Autowired
    private ICtlgDtllEntrdAlmcnService iCtlgDtllEntrdAlmcnService;

}
