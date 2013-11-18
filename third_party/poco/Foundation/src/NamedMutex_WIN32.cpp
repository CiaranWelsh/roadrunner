//
// NamedMutex_WIN32.cpp
//
// $Id: //poco/1.4/Foundation/src/NamedMutex_WIN32.cpp#1 $
//
// Library: Foundation
// Package: Processes
// Module:  NamedMutex
//
// Copyright (c) 2004-2006, Applied Informatics Software Engineering GmbH.
// and Contributors.
//
// Permission is hereby granted, free of charge, to any person or organization
// obtaining a copy of the software and accompanying documentation covered by
// this license (the "Software") to use, reproduce, display, distribute,
// execute, and transmit the Software, and to prepare derivative works of the
// Software, and to permit third-parties to whom the Software is furnished to
// do so, all subject to the following:
// 
// The copyright notices in the Software and this entire statement, including
// the above license grant, this restriction and the following disclaimer,
// must be included in all copies of the Software, in whole or in part, and
// all derivative works of the Software, unless such copies or derivative
// works are solely in the form of machine-executable object code generated by
// a source language processor.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE, TITLE AND NON-INFRINGEMENT. IN NO EVENT
// SHALL THE COPYRIGHT HOLDERS OR ANYONE DISTRIBUTING THE SOFTWARE BE LIABLE
// FOR ANY DAMAGES OR OTHER LIABILITY, WHETHER IN CONTRACT, TORT OR OTHERWISE,
// ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
// DEALINGS IN THE SOFTWARE.
//


#include "Poco/NamedMutex_WIN32.h"
#include "Poco/Exception.h"


namespace Poco {


NamedMutexImpl::NamedMutexImpl(const std::string& name):
	_name(name)
{
	_mutex = CreateMutexA(NULL, FALSE, _name.c_str());
	if (!_mutex) 
		throw SystemException("cannot create named mutex", _name);
}


NamedMutexImpl::~NamedMutexImpl()
{
	CloseHandle(_mutex);
}


void NamedMutexImpl::lockImpl()
{
	switch (WaitForSingleObject(_mutex, INFINITE))
	{
	case WAIT_OBJECT_0:
		return;
	case WAIT_ABANDONED:
		throw SystemException("cannot lock named mutex (abadoned)", _name);
	default:
		throw SystemException("cannot lock named mutex", _name);
	}
}


bool NamedMutexImpl::tryLockImpl()
{
	switch (WaitForSingleObject(_mutex, 0))
	{
	case WAIT_OBJECT_0:
		return true;
	case WAIT_TIMEOUT:
		return false;
	case WAIT_ABANDONED:
		throw SystemException("cannot lock named mutex (abadoned)", _name);
	default:
		throw SystemException("cannot lock named mutex", _name);
	}
}


void NamedMutexImpl::unlockImpl()
{
	ReleaseMutex(_mutex);
}


} // namespace Poco
