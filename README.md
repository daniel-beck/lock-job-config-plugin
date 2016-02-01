# Lock Job Config Plugin

This is a utility plugin for Jenkins that helps use cases that programmatically generate/update job configurations by disabling the UI.

## Usage

This plugin has no UI and is not useful to anyone exclusively configuring jobs from the Jenkins UI.

The following snippet demonstrates use of this plugin:

	<?xml version='1.0' encoding='UTF-8'?>
	<project>
	  <keepDependencies>false</keepDependencies>
	  <properties>
	    <config-lock>
	      <title>custom title</title>
	      <message>custom message</message>
	    </config-lock>
	  </properties>
	  …
	</project>

Any job with the `config-lock` job property will not have an accessible config page.

Both `title` and `message` are optional, and will use a default text if not defined.

If you want to remove this configuration dialog lock, remove the `config-lock` item from the `properties` list. Note that having no `properties` element (e.g. when POSTing `config.xml`) will result in the previously set properties being reused.

## License

MIT License
