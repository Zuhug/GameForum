package top.zugovo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import top.zugovo.entity.Account;
import top.zugovo.entity.Comment;
import top.zugovo.entity.vo.ArticalVO;
import top.zugovo.entity.vo.CommentVO;
import top.zugovo.service.CommentService;
import top.zugovo.utils.PageResult;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * 第一次进入该页面, 获取Comment
     * @param id
     * @param start
     * @param session
     * @return
     */
    @GetMapping("/user/article-detail/{id}/{start}")
    public String toArticalDetail(@PathVariable int id, @PathVariable int start, HttpSession session) {
        PageResult<ArticalVO> articals = (PageResult<ArticalVO>) session.getAttribute("articals");
        ArticalVO detail = articals.getRows().get(id);
        session.setAttribute("detail", detail);
        PageResult<CommentVO> comments = commentService.queryCommentsByAid(detail.getAid(), start);
        session.setAttribute("comments", comments);
        return "redirect:/user/artical";
    }

    /**
     * 刷新页面之后再次获取Comment
     * @param start
     * @param session
     * @return
     */
    @GetMapping("/user/article-detail/{start}")
    public String refresh(@PathVariable int start, HttpSession session) {
        ArticalVO detail = (ArticalVO) session.getAttribute("detail");
        PageResult<CommentVO> comments = commentService.queryCommentsByAid(detail.getAid(), start);
        session.setAttribute("comments", comments);
        return "redirect:/user/artical";
    }

    /**
     * 发表评论
     * @param content: 评论内容
     * @param session: 用于获取当前板块, 当前帖子信息
     * @return
     */
    @PutMapping("/user/publish-comment")
    public String comment(String content, HttpSession session) {

        // 拿到账户信息
        Account account = (Account) session.getAttribute("loginAccount");
        // 拿到帖子信息
        ArticalVO articalVO = (ArticalVO) session.getAttribute("detail");
        Comment comment = new Comment();
        comment.setAid(articalVO.getAid());
        comment.setUid(account.getUid());
        comment.setCommentContent(content);
        commentService.saveCommentService(comment);

        return "redirect:/user/article-detail/1";
    }

}
