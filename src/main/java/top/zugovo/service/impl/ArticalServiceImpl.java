package top.zugovo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zugovo.entity.Artical;
import top.zugovo.entity.User;
import top.zugovo.entity.vo.ArticalVO;
import top.zugovo.mapper.ArticalMapper;
import top.zugovo.mapper.UserMapper;
import top.zugovo.service.ArticalService;
import top.zugovo.utils.PageResult;
import top.zugovo.utils.PageUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticalServiceImpl implements ArticalService {

    @Autowired
    private ArticalMapper articalMapper;

    @Autowired
    private UserMapper userMapper;


    public void setArticalMapper(ArticalMapper articalMapper) {
        this.articalMapper = articalMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public PageResult<ArticalVO> queryAllByTid(Integer id, Integer start) {
        // 传给前端展示的Artical数据
        List<ArticalVO> articalVOS = new ArrayList<>();

        // 使用pageHelper, 设置开始页, 和每页的大小, 根据id降序
        Page ps = PageHelper.startPage(start, 5, "id desc");
        // 得到查询数据
        List<Artical> articals = articalMapper.queryArticalsByTid(id);
        // 将查询的数据封装到PageInfo中
        PageInfo<Artical> result = new PageInfo<>(articals);

        for (Artical artical : articals) {
            // 得到User信息
            User user = userMapper.findUserById(artical.getUid());
            // 封装ArticalVO
            ArticalVO articalVO = new ArticalVO();
            articalVO.setAid(artical.getId());
            articalVO.setContent(artical.getContent());
            articalVO.setTitle(artical.getTitle());
            articalVO.setPublishTime(
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                            .format(artical.getPublishTime())
            );
            articalVO.setAuthorName(user.getUsername());
            articalVO.setAuthorImg(user.getImgUrl());
            articalVOS.add(articalVO);
        }

        //将前端的东西放入PageResult
        PageResult<ArticalVO> articalPage = new PageResult<>();
        articalPage.setRows(articalVOS);
        // 将分页信息封装到PageResult
        PageUtil.setterPageResult(articalPage, result);

        return articalPage;
    }

    @Override
    public PageResult<Artical> queryArticalsByUid(Integer id, Integer start) {

        Page ps = PageHelper.startPage(start, 5);
        List<Artical> articals = articalMapper.queryArticalsByUid(id);
        PageInfo<Artical> result = new PageInfo<>(articals);
        PageResult<Artical> articalPage = new PageResult<>();
        articalPage.setRows(articals);
        PageUtil.setterPageResult(articalPage, result);

        return articalPage;
    }

    @Override
    public void saveArtical(Artical artical) {
        articalMapper.saveArtical(artical);
    }

    @Override
    public void updateArtical(Artical artical) {
        articalMapper.updateArtical(artical);
    }
}
