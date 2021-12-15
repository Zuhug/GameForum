package top.zugovo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zugovo.entity.Artical;
import top.zugovo.mapper.ArticalMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class GameForumApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    ArticalMapper articalMapper;

    @Test
    void contextLoads() throws SQLException {
//        // 查看一下默认使用的数据源: com.zaxxer.hikari.HikariDataSource
//        System.out.println(dataSource.getClass());
//
//        // 获得数据库连接
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);
//
//        // 关闭连接
//        connection.close();


//        Page ps = PageHelper.startPage(1, 5, "id desc");
//        List<Artical> list = articalMapper.queryArticalsByTid(1);
//        PageInfo<Artical> result = new PageInfo<>(list);
//        System.out.println("result => " + result);
//        for (Artical artical : result.getList()) {
//            System.out.println(artical);
//        }

    }

}
