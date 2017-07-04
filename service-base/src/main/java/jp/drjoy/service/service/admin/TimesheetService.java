/**
* Copyright (c) Acroquest Technology Co., Ltd. All Rights Reserved.
* Please read the associated COPYRIGHTS file for more details.
*
* THE SOFTWARE IS PROVIDED BY Acroquest Technology Co., Ltd.,
* WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
* BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
* IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDER BE LIABLE FOR ANY
* CLAIM, DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
* OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
*/

package jp.drjoy.service.service.admin;

import jp.drjoy.service.dto.admin.TimesheetsDto;
import jp.drjoy.service.service.BaseService;
import jp.drjoy.service.util.common.ListJson;

public interface TimesheetService extends BaseService<TimesheetsDto> {

	public ListJson<TimesheetsDto> findTimeSheetsByTypeAndContent(TimesheetsDto timesheetsDto);

}
