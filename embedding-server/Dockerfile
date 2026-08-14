# Data Agent 嵌入服务（FastEmbed + multilingual-e5-large）
FROM python:3.11-slim

ENV PYTHONUNBUFFERED=1 \
    PIP_NO_CACHE_DIR=1 \
    PORT=8000 \
    EMBED_MODEL=intfloat/multilingual-e5-large

WORKDIR /app

# 系统依赖（onnxruntime 运行时所需）
RUN apt-get update && apt-get install -y --no-install-recommends \
        libgomp1 \
    && rm -rf /var/lib/apt/lists/*

COPY requirements.txt ./
RUN pip install -r requirements.txt

COPY embedding_server.py .

# 构建时预下载并 warmup 模型，保证容器启动即可用、首次请求不慢
RUN python -c "from fastembed import TextEmbedding; TextEmbedding(model_name='intfloat/multilingual-e5-large').embed(['warmup'])"

EXPOSE 8000

HEALTHCHECK --interval=10s --timeout=5s --start-period=60s --retries=5 \
  CMD python -c "import urllib.request; urllib.request.urlopen('http://127.0.0.1:8000/health')" || exit 1

CMD ["python", "embedding_server.py"]
