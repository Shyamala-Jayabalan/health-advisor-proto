// Databricks notebook source
<<<<<<< HEAD
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
=======
//The following notebook will read the storage account that contains the real live transactions 
//TODO: Parameters? Dynamic execution (contract = schema/etc)

// COMMAND ----------

// MAGIC %run ./setup

// COMMAND ----------

val df = spark
  .read.format("avro")
  .option("infereSchema", true)
  .load(path+"landing/lv-iot-streaming/01/2019/09/28/*") //TODO: Parametes?

// COMMAND ----------


val impressionSchema = new StructType()
    .add("EntityType", StringType, true)
    .add("impressionDate", StringType, true)
    .add("advertID", StringType, true)
    .add("impressionURL", StringType, true)
    .add("sessionID", StringType, true)
    .add("firstName", StringType, true)
    .add("lastName", StringType, true)


val impressionsDF = df
  .select($"body".cast("string").alias("json"))
  .withColumn("data", from_json(col("json"), impressionSchema))
  .filter($"data.EntityType" === "Impressions")
  .select("data.*")

//display(impressionsDF)

// COMMAND ----------


val advertsSchema = new StructType()
    .add("EntityType", StringType, true)
    .add("createdDate", StringType, true)
    .add("advertID", StringType, true)
    .add("advertName", StringType, true)
    .add("brand", StringType, true)


val advertsDF = df
  .select($"body".cast("string").alias("json"))
  .withColumn("data", from_json(col("json"), advertsSchema))
  .filter($"data.EntityType" === "Adverts")
  .select("data.*")

//display(advertsDF)
>>>>>>> dev
