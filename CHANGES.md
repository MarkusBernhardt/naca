# Naca changes.txt

## Version 1.1.0 02/03/2009

- NacaTrans: No changes
- JLib: No changes

- NacaRT: 
	This package contains the merge of nacaRTIdeaWeb.zip and naca-1.0.0.zip.
	Some missing jar files for online programs have been added.
	New flags are added into nacaRT.cfg configuration file
		AlternateResourcePath. Gives a 2nd path to a resource directory. It completes ResourcePath parameter.
		SimulateRealEnvironment. Set it to true only to disable DB accesses. It must be set to must or removed if DB access is used.

- CobolAppOnline: New directory; it contains standard resource definition for error and login screen. 
	They can be customized depending on target application.

- NacaSamples: New directory: It contains a sample online program. 
	The original cobol files are in NacaSamples\cobol
	The transcoded files are in NacaSamples\src
	The transcoder configuration is in NacaSamples\trans
	It's documented in NacaSamples\NacaSample.doc
	

	

	
	
	
	


