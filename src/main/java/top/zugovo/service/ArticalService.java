package top.zugovo.service;

import top.zugovo.entity.Artical;
import top.zugovo.entity.vo.ArticalVO;
import top.zugovo.utils.PageResult;

public interface ArticalService {

    /**
     * 通过tid查询所有的帖子
     * @param id
     * @param start
     * @return
     */
    public PageResult<ArticalVO> queryAllByTid(Integer id, Integer start);

    /**
     * 通过uid获取所有的帖子信息
     * @param id
     * @param start
     * @return
     */
    public PageResult<Artical> queryArticalsByUid(Integer id, Integer start);

    /**
     * 保存帖子
     * @param artical
     */
    public void saveArtical(Artical artical);

    /**
     * 更新帖子信息
     * @param artical
     */
    public void updateArtical(Artical artical);

}
