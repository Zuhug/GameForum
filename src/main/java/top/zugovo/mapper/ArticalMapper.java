package top.zugovo.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.zugovo.entity.Artical;

import java.util.List;

@Mapper
@Repository
public interface ArticalMapper {

    // 根据tid查询
    public List<Artical> queryArticalsByTid(Integer tid);

    // 增: 发布一篇帖子
    public int saveArtical(Artical artical);

    // 改: 修改文章内容
    public int updateArtical(Artical artical);

    // 删: 删除一篇文章
    public int dropArtical(Integer id);

    // 查: 通过id查询
    public Artical findArticalById(Integer id);

    // 查询某个讨论区的所有帖子
    public List<Artical> queryAllByTid(Integer id);

    // 查询: 查询某个用户发布的所有帖子
    public List<Artical> queryArticalsByUid(Integer id);

}
