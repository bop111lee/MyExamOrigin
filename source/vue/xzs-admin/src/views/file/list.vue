<template>
  <div class="app-container">
    <el-form :model="queryParam" ref="queryForm" :inline="true">
      <el-form-item label="输入文件名：">
        <el-input></el-input>
      </el-form-item>
      <el-form-item :inline-message="true">
        <el-button type="primary" @click="">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-upload>
          <el-button type="success">点击上传</el-button>
        </el-upload>
      </el-form-item>
    </el-form>
    <el-table>
      <el-table-column prop="id" label="Id" width="100"/>
      <el-table-column prop="title" label="标题" show-overflow-tooltip/>
      <el-table-column prop="" label="操作" show-overflow-tooltip>
        <el-button size="mini" class="link-left"></el-button>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  export default {
    name: 'list'
  }
</script>

<style scoped>

</style>
