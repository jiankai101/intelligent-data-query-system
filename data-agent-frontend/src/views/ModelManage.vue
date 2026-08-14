<template>
  <div style="padding:16px">
    <el-card shadow="never">
      <template #header>
        <div style="display:flex;justify-content:space-between;align-items:center">
          <span style="font-weight:700">⚙️ 模型管理</span>
          <div>
            <el-button size="small" @click="load">刷新</el-button>
            <el-button size="small" type="primary" :loading="saving" @click="save">保存并生效</el-button>
          </div>
        </div>
      </template>
      <el-alert type="info" :closable="false" style="margin-bottom:12px"
        title="配置系统使用的 LLM 对话模型与 Embedding 向量模型，保存后即时生效（无需重启后端）。向量维度需与已有向量库一致。" />
      <el-row :gutter="16">
        <el-col :span="12">
          <el-card shadow="never">
            <template #header><b>🤖 LLM 对话模型</b></template>
            <el-form label-width="110px" label-position="left">
              <el-form-item label="模型名称">
                <el-input v-model="llm.modelName" placeholder="例如 deepseek-v4-flash" />
              </el-form-item>
              <el-form-item label="接口地址">
                <el-input v-model="llm.baseUrl" placeholder="OpenAI 兼容地址，不含 /v1" />
              </el-form-item>
              <el-form-item label="API Key">
                <el-input v-model="llm.apiKey" show-password placeholder="sk-..." />
              </el-form-item>
              <el-form-item label="服务商">
                <el-input v-model="llm.provider" placeholder="例如 OpenAI 兼容" />
              </el-form-item>
              <el-form-item label="启用">
                <el-switch v-model="llm.enabled" />
              </el-form-item>
            </el-form>
          </el-card>
        </el-col>
        <el-col :span="12">
          <el-card shadow="never">
            <template #header><b>🧬 Embedding 向量模型</b></template>
            <el-form label-width="110px" label-position="left">
              <el-form-item label="模型名称">
                <el-input v-model="embedding.modelName" placeholder="例如 intfloat/multilingual-e5-large" />
              </el-form-item>
              <el-form-item label="接口地址">
                <el-input v-model="embedding.baseUrl" placeholder="例如 http://localhost:8000" />
              </el-form-item>
              <el-form-item label="向量维度">
                <el-input-number v-model="embedding.dimensions" :min="1" style="width:160px" />
              </el-form-item>
              <el-form-item label="服务商">
                <el-input v-model="embedding.provider" placeholder="例如 OpenAI 兼容" />
              </el-form-item>
              <el-form-item label="启用">
                <el-switch v-model="embedding.enabled" />
              </el-form-item>
            </el-form>
          </el-card>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { ElMessage } from 'element-plus'
import http from '@/api/http'

const llm = reactive<any>({})
const embedding = reactive<any>({})
const saving = ref(false)

async function load() {
  const res: any = await http.get('/api/model')
  Object.assign(llm, { modelName: '', baseUrl: '', apiKey: '', provider: '', enabled: true }, res.llm || {})
  Object.assign(embedding, { modelName: '', baseUrl: '', apiKey: '', provider: '', enabled: true, dimensions: 1024 }, res.embedding || {})
}
async function save() {
  saving.value = true
  try {
    await http.put('/api/model', { llm, embedding })
    ElMessage.success('已保存并生效')
  } finally {
    saving.value = false
  }
}
onMounted(load)
</script>
