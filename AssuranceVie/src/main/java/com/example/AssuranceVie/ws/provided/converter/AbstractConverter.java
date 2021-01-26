package com.example.AssuranceVie.ws.provided.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<Bean,Vo> {
    public abstract Bean toBean(Vo vo);
    public abstract Vo toVo(Bean bean);

    public List<Bean> toBean(List<Vo> vos){
        List list=new ArrayList();
        for (Vo vo:vos) {
            list.add(toBean(vo));
        }
        return list;
    }
    public List<Vo> toVo(List<Bean> beans){
        List list=new ArrayList();
        for (Bean bean:beans) {
            list.add(toVo(bean));
        }
        return list;
    }

}