// Databricks notebook source
// MAGIC %run ./setup

// COMMAND ----------

println(dbutils.fs.ls(path))

// COMMAND ----------

val df = spark.read.option("inferSchema", true).json(path+"lv-iot-streaming/01/2019/09/23/21/47") //.option("header", true)

// COMMAND ----------

display(df)

// COMMAND ----------

//Read if needed
df
 .coalesce(1)
 .write
 .mode("overwrite")
 .option("header", "true")
 .format("com.databricks.spark.csv")
 .save(path)