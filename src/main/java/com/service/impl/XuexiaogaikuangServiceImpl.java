package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.XuexiaogaikuangDao;
import com.entity.XuexiaogaikuangEntity;
import com.service.XuexiaogaikuangService;
import com.entity.view.XuexiaogaikuangView;

/**
 *  服务实现类
 * @author 
 * @since 2021-02-22
 */
@Service("xuexiaogaikuangService")
@Transactional
public class XuexiaogaikuangServiceImpl extends ServiceImpl<XuexiaogaikuangDao, XuexiaogaikuangEntity> implements XuexiaogaikuangService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<XuexiaogaikuangView> page =new Query<XuexiaogaikuangView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
