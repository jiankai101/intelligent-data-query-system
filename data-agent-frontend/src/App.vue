<script setup lang="ts">
import { useRoute } from 'vue-router'

const route = useRoute()
const activeMenu = route.path
</script>

<template>
  <el-container class="layout">
    <el-aside width="220px" class="layout__aside">
      <div class="layout__brand">电商经营数据智能问答</div>
      <el-menu :default-active="activeMenu" router class="layout__menu">
        <el-menu-item index="/">🏠 首页</el-menu-item>
        <el-menu-item index="/chat">💬 数据问答</el-menu-item>
        <el-menu-item index="/orders">📦 订单管理</el-menu-item>
        <el-menu-item index="/products">🛍️ 商品管理</el-menu-item>
        <el-menu-item index="/shops">🏬 店铺管理</el-menu-item>
        <el-menu-item index="/inventory">📊 库存管理</el-menu-item>
        <el-menu-item index="/refunds">↩️ 退款管理</el-menu-item>
        <el-menu-item index="/debug">🔍 调试管理</el-menu-item>
        <el-menu-item index="/users">👤 用户管理</el-menu-item>
        <el-sub-menu index="asset-group">
          <template #title>🍱 数据资产中心</template>
          <el-menu-item index="/asset">📊 资产总览</el-menu-item>
          <el-menu-item index="/asset/business">🗂️ 业务表</el-menu-item>
          <el-menu-item index="/asset/schema">🧬 Schema 字段</el-menu-item>
          <el-menu-item index="/asset/relation">🔗 表关系</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="knowledge-group">
          <template #title>🧠 知识库管理</template>
          <el-menu-item index="/knowledge">📚 知识库内容</el-menu-item>
          <el-menu-item index="/knowledge/tags">🏷️ 标签管理</el-menu-item>
          <el-menu-item index="/knowledge/feedback">🔄 反馈闭环</el-menu-item>
        </el-sub-menu>
      </el-menu>
    </el-aside>
    <el-main class="layout__main">
      <router-view />
    </el-main>
  </el-container>
</template>

<style>
body { margin: 0; background: #f5f6fa; }
.layout { min-height: 100vh; }
.layout__aside {
  background: #fff;
  border-right: 1px solid #eef0f4;
}
.layout__brand {
  padding: 20px 18px;
  font-weight: 800;
  font-size: 16px;
  color: #ea580c;
  letter-spacing: 0.02em;
}
.layout__menu { border-right: none; }
.layout__main { padding: 20px; }
</style>
