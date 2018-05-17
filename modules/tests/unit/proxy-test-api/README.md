# Liferay Proxy Unit Test API

## Overview

This module provides a convenient way to create proxy objects for unit tests
through the **DependencyProxyManager**.

## Dependency Proxy Manager

The dependency manager users a return values map keyed with **MethodKey** to
provide its MapBackedInvocationHandler with return values.

The invocation handler used when calling *setProxies* does not keep track of the
method invocations. However, method invocations can be tracked using the
*getCallCollectingProxyInstance* method.

Proxy instances can only be created for Interfaces. Therefore, when calling
*setProxies*, a list of un-proxiable fields is returned so that the test class
can set those fields. All fields up the class hierarchy are checked and either
 returned or set with a proxy.