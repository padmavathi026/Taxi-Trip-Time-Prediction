FROM jupyter/pyspark-notebook:spark-3.1.1

# Install Java and wget
USER root
RUN apt-get update && apt-get install -y openjdk-8-jdk wget

# Set Java home
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV PATH=$PATH:$JAVA_HOME/bin

# Install Hadoop client
RUN wget https://archive.apache.org/dist/hadoop/common/hadoop-3.2.1/hadoop-3.2.1.tar.gz && \
    tar -xvzf hadoop-3.2.1.tar.gz && \
    mv hadoop-3.2.1 /opt/hadoop && \
    rm hadoop-3.2.1.tar.gz

# Set Hadoop environment variables
ENV HADOOP_HOME=/opt/hadoop
ENV PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin
ENV HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop

# Install useful Python libraries
RUN pip install findspark pandas matplotlib seaborn

# Back to jovyan user
USER jovyan
