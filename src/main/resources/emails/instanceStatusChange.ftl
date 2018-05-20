<#-- @ftlvariable name="instance" type="com.kpi.dimploma.taleb.model.ProductInstance" -->
<#-- @ftlvariable name="user" type="com.kpi.dimploma.taleb.model.User" -->
Hello ${user.firstName} ${user.lastName}!

Your instance of ${instance.price.product.productName} at ${instance.domain.domainName} changed to ${instance.status.categoryName}