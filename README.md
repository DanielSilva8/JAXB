# JAXB_Simple_Worker
Simple class to manage XML binding, using JAXB.

Example:
//load
File configurationFile = new File("...");
SuiteType suite = JAXB.load(configurationFile, SuiteType.class);

//save
File newConfigurationFile = new File("...");
JAXB.save(newConfigurationFile, suite);
