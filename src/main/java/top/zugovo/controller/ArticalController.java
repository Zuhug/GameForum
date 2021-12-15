package top.zugovo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.zugovo.entity.Account;
import top.zugovo.entity.Artical;
import top.zugovo.entity.Topic;
import top.zugovo.entity.vo.ArticalVO;
import top.zugovo.service.ArticalService;
import top.zugovo.service.TopicService;
import top.zugovo.service.UserService;
import top.zugovo.utils.PageResult;
import javax.servlet.http.HttpSession;

@Controller
public class ArticalController {

    @Autowired
    TopicService topicService;

    @Autowired
    ArticalService articalService;

    @Autowired
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    public void setArticalService(ArticalService articalService) {
        this.articalService = articalService;
    }

    /**
     * 获取某个讨论区下的从start开始获取5个帖子
     * @param session: 用于存放讨论区(topic)和查询出来的ArticalVO (帖子+作者) 信息
     * @param id: 标识是在哪个讨论区(topic)下, 即用户要到那个讨论区下面
     * @param start: 表示从第几条数据开始取
     * @return
     */
    @GetMapping("/user/topic/{id}/{start}")
    public String toTopic(HttpSession session, @PathVariable int id, @PathVariable int start) {
        // 获取讨论区+板块 (topic + plate)信息
        Topic topic = topicService.queryTopicPlate(id);
        // 查询帖子+作者 (artical+user)信息
        PageResult<ArticalVO> articals = articalService.queryAllByTid(id, start);
        session.setAttribute("topic", topic);
        session.setAttribute("articals", articals);
        return "redirect:/user/toTopicDetail";
    }

    /**
     * 发表文章
     * @param myTitle: 帖子的标题
     * @param content: 帖子的具体内容
     * @param session: 获取是当前登录的用户(user), 当前板块(plate), 当前讨论区(topic)信息
     * @return
     */
    @PostMapping("/user/publish-artical")
    public String publishArtical( String myTitle, String content, HttpSession session) {
        // 获取当前登录的用户
        Account loginAccount = (Account) session.getAttribute("loginAccount");
        // 获取当前讨论区+板块信息
        Topic topic = (Topic) session.getAttribute("topic");
        // 发表的文章
        Artical artical = new Artical();
        artical.setTitle(myTitle);
        artical.setContent(content);
        artical.setUid(loginAccount.getUid());
        artical.setTid(topic.getId());
        articalService.saveArtical(artical);
        return "redirect:/user/topic/" + topic.getId() + "/1";
    }

    /**
     * 在用户: '我的主页' -> '我的发帖': 获取所有用户发帖
     * @param uid: 用户id
     * @param start: 查询数据的起始位置
     * @param session: 存放得到的帖子信息
     * @return
     */
    @GetMapping("/user/getAllArticalsByUid/{uid}/{start}")
    public String queryAllArticalsByUid(@PathVariable int uid, @PathVariable int start, HttpSession session) {

        PageResult<Artical> articalPageResult = articalService.queryArticalsByUid(uid, start);
        session.setAttribute("articalPageResult", articalPageResult);

        return "redirect:/user/info.html";
    }

    /**
     * 用户点击下面的分页按钮, 查询帖子信息
     * @param uid: 用户id
     * @param start: 起始位置
     * @param session: 存放得到的帖子信息
     * @return
     */
    @GetMapping("/user/getAllArticalsByUid2/{uid}/{start}")
    public String queryAllArticalsByUid2(@PathVariable int uid, @PathVariable int start, HttpSession session) {

        PageResult<Artical> articalPageResult = articalService.queryArticalsByUid(uid, start);
        session.setAttribute("articalPageResult", articalPageResult);

        // 返回一个组件 ( 通过Thymeleaf中的load()加载 )
        return "component1";
    }

    /**
     * 修改帖子
     * @param session
     * @param title
     * @param numbers: 在当前保存的所有artical的下标
     * @return
     */
    @PutMapping("/update")
    public String updateArtical(HttpSession session, String title, Integer numbers) {
        Account account = (Account) session.getAttribute("loginAccount");
        PageResult<Artical> articals = (PageResult<Artical>) session.getAttribute("articalPageResult");
        Artical artical = articals.getRows().get(numbers);
        artical.setTitle(title);
        articalService.updateArtical(artical);
        return "redirect:/user/getAllArticalsByUid1/" + account.getUid() + "/1";
    }

    /**
     * 删除帖子
     * @param session
     * @param aid
     * @return
     */
    @DeleteMapping("/delete")
    public String deleteArtical(HttpSession session, Integer aid) {
        Account account = (Account) session.getAttribute("loginAccount");
        PageResult<Artical> articalPageResult = (PageResult<Artical>) session.getAttribute("articalPageResult");
        Artical artical = articalPageResult.getRows().get(aid);
        userService.deleteArtical(artical.getId());
        return "redirect:/user/getAllArticalsByUid1/" + account.getUid() + "/1";
    }

}
