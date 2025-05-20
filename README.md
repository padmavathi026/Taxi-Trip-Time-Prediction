# Taxi-Trip-Time-Prediction


<h1>🚕 Distributed Taxi Trip Duration Prediction with Hadoop, PySpark, and ML</h1>

<h2>Description</h2>
This project focuses on building an end-to-end big data pipeline to process 197+ million NYC Yellow Taxi records from 2019–2023. It implements distributed HDFS ingestion, PySpark-based EDA, and advanced machine learning models (regression, classification, clustering) for trip time prediction, built inside a Docker-based Hadoop and Spark ecosystem.

<h3>🔧 Tech Stack</h3>


- Apache Hadoop (HDFS) on Docker

- PySpark (MLlib) for distributed data processing

- Jupyter Notebook container for interactive exploration

- Docker Compose for managing services

- Java API for HDFS ingestion

- Parquet format for efficient big data handling

<h4>📂 Project Structure</h4>

.
- ├── DIC EDA.ipynb                  # PySpark EDA notebook
- ├── Pyspark.ipynb                  # Data preprocessing + ML models
- ├── spark.py                       # Wordcount example with Spark
- ├── HDFSDataIngestion.java         # Java-based file upload to HDFS
- ├── docker-compose.yaml            # Hadoop cluster services
- ├── docker-compose.override.yaml   # Jupyter notebook config
- ├── config/                        # Hadoop XML config files
- ├── DIC FINAL submission report.pdf


<h5>🧪 Machine Learning Objectives</h5>

- 1. Trip Duration Prediction (Regression)
Model: Linear Regression

Metric: R² = 1.0, MAE = 0.0081

Features: Time, trip distance, fare, location, passenger count

- 2. Delay Risk Classification (Binary)
Model: Decision Tree

Metric: Accuracy = 0.9878, AUC = 0.9988

Logic: Label "Delayed" if trip duration > 90th percentile

- 3. Temporal Clustering
Model: KMeans (k=5)

Insight: Grouped trips by pickup time/day/month

Metric: WSSSE = 32,162.13 (compact clusters)


<h6> 🔁 Data Pipeline Overview </h6>

- <b>Dockerized Hadoop Cluster</b>

Namenode + Datanode + ResourceManager + NodeManager + Jupyter

Compose file defined in docker-compose.yaml

- <b>Data Ingestion</b>

Java file ingestion (HDFSDataIngestion.java)

Alternative: hdfs dfs -put for bulk uploads

File type: .parquet (efficient, columnar format)

- <b>Exploratory Data Analysis (EDA)</b>

Distributions (distance, fare, tip, time)

Outliers via IQR + Z-score

Trends across time (hour, day, month)

Location-based averages

- <b>Cleaning & Feature Engineering</b>

KNN, median/mode imputation

One-hot encoding for time fields

Feature scaling using StandardScaler

VectorAssembler for MLlib input


<h7> 📊 Evaluation Summary </h7>

| Task                      | Model             | Key Metrics                         |
| ------------------------- | ----------------- | ----------------------------------- |
| Trip Duration Prediction  | Linear Regression | R² = 1.0 , RMSE = 0.0099            |
| Delay Risk Classification | Decision Tree     | Accuracy = 0.9878, AUC = 0.9988     |
| Temporal Clustering       | KMeans (k=5)      | WSSSE = 32,162.13                   |


<h8> 📁 Data Access in HDFS </h8>

| Item                                 | HDFS Path                                                                     |
|--------------------------------------|-------------------------------------------------------------------------------|
| Input Data                           | `hdfs://namenode:9000/user/raghu/input/`                                      |
| Metrics                              | `hdfs://namenode:9000/user/raghu/metrics/model_metrics/`                      |
| KMeans Predictions                   | `hdfs://namenode:9000/user/raghu/predictions/kmeans_predictions/`             |
| Linear Regression Predictions        | `hdfs://namenode:9000/user/raghu/predictions/lr_predictions/`                 |
| Decision Tree Predictions            | `hdfs://namenode:9000/user/raghu/predictions/dt_predictions/`                 |
| Decision Tree Tuned Model (Data)     | `hdfs://namenode:9000/user/raghu/models/dt_tuned_model/data/`                 |
| Decision Tree Tuned Model (Meta)     | `hdfs://namenode:9000/user/raghu/models/dt_tuned_model/metadata/`             |
| Linear Regression Tuned Model (Data) | `hdfs://namenode:9000/user/raghu/models/lr_tuned_model/data/`                 |
| Linear Regression Tuned Model (Meta) | `hdfs://namenode:9000/user/raghu/models/lr_tuned_model/metadata/`             |
| KMeans Tuned Model (Data)            | `hdfs://namenode:9000/user/raghu/models/kmeans_tuned_model/data/`             |
| KMeans Tuned Model (Meta)            | `hdfs://namenode:9000/user/raghu/models/kmeans_tuned_model/metadata/`         |
| Phase 1 Clean File                   | `hdfs://namenode:9000/user/raghu/phase1/phase1/`                              |


<h8> 🚀 Quickstart Instructions </h8>

<b>Start the Hadoop Cluster:</b>

docker-compose up -d

<b>Access Jupyter Notebook:</b>

Navigate to http://localhost:8888

<b> Load Data to HDFS: </b>

hdfs dfs -mkdir -p /user/raghu/input/
hdfs dfs -put *.parquet /user/raghu/input/

<b> Run ML Pipeline: </b>

Open Pyspark.ipynb in Jupyter and execute all steps.


