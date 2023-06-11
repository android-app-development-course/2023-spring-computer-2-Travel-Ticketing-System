<!--本页面由uniapp切片工具生成，uni-app切片-可视化设计工具(一套代码编译到7个平台iOS、Android、H5、小程序)，软件下载地址：http://www.ymznkf.com/new_view_669.htm -->
<template>
  <view style="display: flex; flex-direction: column; align-items: center; justify-content: center;">
    <view style="margin-top: 40px;">
      <image v-on:click="no_order_in_order_list_7_7_click()" src="../../static/icon/no_order.jpg" style="width: 200px; height: 200px; object-fit: cover;"></image>
      <text decode="true" style="font-size: 16px; color: #333; margin-top: 20px;">暂时没有订单哦</text>
      <button v-on:click="btGo_11_click()" style="background-color: #3399FF; color: #fff; font-size: 16px; border-radius: 4px; padding: 10px 20px; margin-top: 20px;">去购票</button>
    </view>
    <view style="font-size: 16px; color: #999; margin-top: 20px;">{{loadingText}}</view>
    <view style="height: 50px;"></view>
  </view>
</template>

<style scoped>
.top {
  height: 250rpx;
  position: relative;
}
.top .background {
  background-color: #5199ff;
  border-bottom-left-radius: 22px;
  border-bottom-right-radius: 22px;
  position: absolute;
  height: 180rpx;
  width: 100%;
}
.icon {
  color: #96a1ae;
  font-size: 40rpx;
}
.user-card {
  height: 170rpx;
  padding: 0 15px;
}
.user-card .card {
  position: relative;
  bottom: 62px;
  height: 250rpx;
  background-color: white;
  border-radius: 5px;
}
.user-card .card .top {
  height: 30%;
  position: relative;
}
.user-card .card .top .userImage {
  position: absolute;
  bottom: 24%;
  left: 10%;
  width: 150rpx;
  height: 150rpx;
  overflow: hidden;
  border-radius: 50%;
  border: 2px solid white;
}
.user-card .card .bottom {
  display: flex;
  height: 70%;
}
.user-card .card .bottom .left {
  width: 80%;
  height: 100%;
  position: relative;
}
.user-card .card .bottom .left .user-text {
  width: 100%;
  font-size: 1.6em;
  padding-left: 80rpx;
  height: 50%;
}
.user-card .card .bottom .left .user-phone {
  color: #96a1ae;
  padding-left: 80rpx;
  height: 50%;
  width: 100%;
  font-size: 0.9em;
}
.user-card .card .bottom .right {
  width: 20%;
  height: 50%;
}
.list-card {
  padding: 0 15px;
}
.list-card .card {
  border-radius: 5px;
  position: relative;
  background-color: white;
  border-radius: 5px;
  padding: 5px 30px;
}
.list-card .card .item {
  display: flex;
  height: 120rpx;
}
.list-card .card .item .left {
  width: 15%;
}
.list-card .card .item .left image {
  width: 70rpx;
  height: 70rpx;
}
.list-card .card .item .center {
  width: 65%;
  display: flex;
  justify-content: start;
  align-items: center;
  font-size: 1.1em;
}
.list-card .card .item .right {
  width: 20%;
  justify-content: flex-end;
}
.item-bottom-solid {
  border-bottom: 1px solid #d4d6da;
}
.quit {
  height: 100rpx;
  margin-top: 50px;
}
.quit .btn {
  background-color: #4f99ff;
  border-radius: 30px;
  width: 80%;
  color: white;
  font-size: 1.2em;
  height: 100%;
}
.flex-center {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
