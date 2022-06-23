package com.solvd.laba.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.laba.carina.demo.api.*;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;


public class MyApiTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "max")
    public void getPostsTest() {
        GetPostMethod api = new GetPostMethod();
        api.callAPI();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/posts/_get/rs.schema");

    }

    @Test()
    @MethodOwner(owner = "max")
    public void getPostsOneTest() {
        GetPostOneMethod api = new GetPostOneMethod();
        api.callAPI();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/posts/_get_one/rs.schema");

    }

    @Test()
    @MethodOwner(owner = "max")
    public void getPostsCommentTest() {
        GetPostCommentMethod api = new GetPostCommentMethod();
        api.callAPI();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/posts/_get_comment/rs.schema");

    }

    @Test()
    @MethodOwner(owner = "max")
    public void getPostsCommentByIdTest() {
        GetPostCommentByIdMethod api = new GetPostCommentByIdMethod();
        api.callAPI();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/posts/_get_comment/rs.schema");

    }

    @Test()
    @MethodOwner(owner = "max")
    public void deletePostTest() {
        DeletePostMethod api = new DeletePostMethod();
        api.callAPI();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "max")
    public void putPostTest() {
        PutPostMethod api = new PutPostMethod();
        api.callAPI();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "max")
    public void patchPostTest() {
        PatchPostMethod api = new PatchPostMethod();
        api.callAPI();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "max")
    public void createPostTest() {
        PostPostMethod api = new PostPostMethod();
        api.setProperties("api/posts/post.properties");
        api.callAPI();
        api.validateResponse();
    }


    @Test()
    @MethodOwner(owner = "max")
    public void createUserTest() {
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postUserMethod.callAPI();
        postUserMethod.validateResponse();

    }

    @Test()
    @MethodOwner(owner = "max")
    public void createUserWithoutNameTest() {
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.getProperties().remove("name");
        postUserMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postUserMethod.callAPI();
        postUserMethod.validateResponse();

    }
}
