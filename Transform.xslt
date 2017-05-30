<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" indent="yes" />
    <xsl:template match="entry">
        <entry field = "{field}" />
    </xsl:template>

    <xsl:template match="root">
        <root>
            <xsl:apply-templates />
        </root>
    </xsl:template>
</xsl:stylesheet>

<!--<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:for-each select="//font">
        <font font="{font}"/>
    </xsl:for-each>
</xsl:stylesheet>-->

<!--<xsl:template match="entry" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <entry font="{font}"/>
</xsl:template>-->


<!--<xsl:for-each select="//ITEM">
<ITEM serialNumber="{SERIALNUMBER}" location="{LOCATION}" barcode="{BARCODE}"/>
</xsl:for-each>-->


<!--<xsl:template match="row">
<row a="{a}" b="{b}" />
</xsl:template>-->
