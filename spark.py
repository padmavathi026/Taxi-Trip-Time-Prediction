
from pyspark import SparkConf, SparkContext

def main():
    conf = SparkConf().setAppName("WordCountDemo")

    sc = SparkContext(conf=conf)
    input_path = "hdfs://namenode/input/README.txt"

    output_path = "hdfs://namenode/output/wordcount_result"
    text_file = sc.textFile(input_path)
    counts = (text_file.flatMap(lambda line: line.split()).map(lambda word: (word, 1)).reduceByKey(lambda a, b: a + b))
    counts.saveAsTextFile(output_path)
    sc.stop()
if __name__ == "__main__":
    main()
