package com.zyw.horrarndoo.yizhi.api;

import com.zyw.horrarndoo.yizhi.model.bean.douban.book.BookListBean;
import com.zyw.horrarndoo.yizhi.model.bean.douban.book.BookDetailBean;
import com.zyw.horrarndoo.yizhi.model.bean.douban.movie.HotMovieBean;
import com.zyw.horrarndoo.yizhi.model.bean.douban.movie.MovieDetailBean;
import com.zyw.horrarndoo.yizhi.model.bean.login.MePricleBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Horrarndoo on 2017/10/16.
 * <p>
 */

public interface DoubanApi {
//    public final static String HOST = "Https://api.douban.com/";
    /**
     * 测试host
     */
    public final static String HOST = "http://59.110.112.73:8082/";

    /**
     * 获取登录验证码（这里模拟另一个接口）
     * userid 用户id
     * auctionId 拍场id
     */
    @GET("api/user/credit")
    Observable<MePricleBean> getLoginCode1(@Query("userId") String userid,
                                          @Query("auctionId") String auctionId);

    @FormUrlEncoded
    @POST("api/user/credit")
    Observable<MePricleBean> getLoginCode(@Header("userId") String userid,
                                          @Field("auctionId") String auctionId);

    /**
     * 豆瓣热映电影，每日更新
     */
    @GET("v2/movie/in_theaters")
    Observable<HotMovieBean> getHotMovie();

    /**
     * 获取电影详情
     *
     * @param id 电影bean里的id
     */
    @GET("v2/movie/subject/{id}")
    Observable<MovieDetailBean> getMovieDetail(@Path("id") String id);

    /**
     * 获取豆瓣电影top250
     *
     * @param start 从多少开始，如从"0"开始
     * @param count 一次请求的数目，如"10"条，最多100
     */
    @GET("v2/movie/top250")
    Observable<HotMovieBean> getMovieTop250(@Query("start") int start, @Query("count") int count);

    /**
     * 根据tag获取图书
     *
     * @param tag   搜索关键字
     * @param start 从多少开始，如从"0"开始
     * @param count 一次请求的数目 最多100
     */

    @GET("v2/book/search")
    Observable<BookListBean> getBookListWithTag(@Query("tag") String tag, @Query("start") int
            start, @Query("count") int count);

    @GET("v2/book/{id}")
    Observable<BookDetailBean> getBookDetail(@Path("id") String id);
}
