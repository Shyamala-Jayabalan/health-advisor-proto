// Databricks notebook source
//Lib if needed
<<<<<<< HEAD

=======
import org.apache.spark.sql.types.{StructType, StructField, LongType, StringType, IntegerType, TimestampType}
import org.apache.spark.sql.functions._
>>>>>>> dev

// COMMAND ----------

//Global Settings

val path = "wasbs://lv-health-adv-store@lvhealthadvstrg.blob.core.windows.net/"
<<<<<<< HEAD
val storageAccount = "lvhealthadvstrg"
val storageKey = "zsC8KArE/0TY5cJmPJ9xCxfY96SnS3or2rxJ4IVFJL0ajXz1dG6uZusIEJaZ8YDJt9goxuB4KBNvP0qQmskciw=="
=======
val storageAccount = "lvhealthadvstrg" //TODO: Security
val storageKey = dbutils.secrets.get(scope = "health-adv-scope", key = "strg-key")//dbutils.secrets.listScopes
>>>>>>> dev

// COMMAND ----------

//"fs.azure.account.key.<storage-account-name>.blob.core.windows.net",
//"<storage-account-access-key>")
spark.conf.set(
  "fs.azure.account.key." + storageAccount + ".blob.core.windows.net",
<<<<<<< HEAD
  storageKey)

// COMMAND ----------

=======
  storageKey)
>>>>>>> dev
