<#import "parts/common.ftlh" as c>

<@c.page>
    Редактор данных о пользователе
    <form action="/user" method="post">
        <input type="text" name="username" value="${user.username}">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}"
                ${user.roles?seq_contains(role)?string("checked", "")}>
                ${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Сохранить</button>
    </form>
</@c.page>