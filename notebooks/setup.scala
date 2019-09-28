// Databricks notebook source
//Lib if needed


// COMMAND ----------

//Global Settings

val path = "wasbs://lv-health-adv-store@lvhealthadvstrg.blob.core.windows.net/"
val storageAccount = "lvhealthadvstrg"
val storageKey = "zsC8KArE/0TY5cJmPJ9xCxfY96SnS3or2rxJ4IVFJL0ajXz1dG6uZusIEJaZ8YDJt9goxuB4KBNvP0qQmskciw=="

// COMMAND ----------

//"fs.azure.account.key.<storage-account-name>.blob.core.windows.net",
//"<storage-account-access-key>")
spark.conf.set(
  "fs.azure.account.key." + storageAccount + ".blob.core.windows.net",
  storageKey)

// COMMAND ----------

