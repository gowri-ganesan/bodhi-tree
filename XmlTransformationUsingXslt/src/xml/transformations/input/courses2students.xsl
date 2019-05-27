<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml"> </xsl:output>
	<xsl:template match="/">
	<students>
	<xsl:apply-templates select="courses/course/students/student" />
	</students>
	</xsl:template>
	
	<xsl:template match="courses/course/students/student">
	<student>
	<xsl:attribute  name="id">
		<xsl:value-of select="@id" />
	</xsl:attribute>
	<first_name>
	<xsl:value-of select="first" />
	</first_name>
	<last_name>
	<xsl:value-of select="last" />
	</last_name>
	
	</student>	
	</xsl:template>
	
</xsl:stylesheet>