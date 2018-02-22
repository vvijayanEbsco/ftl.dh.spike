<#ftl ns_prefixes={"e":"http://www.w3.org/1999/xhtml"} strip_whitespace=true strip_text=true output_format="JSON">
<@compress single_line=true>
<#recurse doc>
<#macro "e:html">
    <#recurse>
</#macro>
<#macro "e:head">
    <#recurse>
</#macro>
<#macro "e:body">
    <#recurse>
</#macro>
<#macro "e:div">
    <#recurse>
</#macro>

<#macro "e:h3">
<#if .node.@class == 'title topictitle3'>
{"reference": "${.node.@@text?upper_case}","sectionName": "${.node.@@text?js_string}"},
</#if>




</#macro>
<#macro @element>
  <#--
	Do Nothing here as we are only handling headers
	<#list .node?children as child><#if child?node_name == 'bold'><span class='bold'>${child}</span><#else>${child}</#if></#list></li>
	

<#list .node?parent as parent><#if parent.@@text?js_string == 'procedure'> ${.node.@@text?js_string}</#if></#list>


<#list .node?children as child><#if child.@class??><#if child.@class == 'topic nested3'> ${child.@@text?js_string}</#if></#if></#list>
  -->
  
</#macro>

</@compress>