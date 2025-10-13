//
//  RCTNodeMediaClient.m
//  
//
//  Created by Mingliang Chen on 2018/2/28.
//  Copyright © 2018-2024年 Mingliang Chen. All rights reserved.
//

#import "RCTNodeMediaClient.h"

@implementation RCTNodeMediaClient

RCT_EXPORT_MODULE(NodeMediaClient);


static NSString *_license = @"";

+ (NSString*)license {
    return _license;
}

+ (void)setLicense:(NSString *)license {
    _license = license;
}

RCT_EXPORT_METHOD(setLicense:(NSString *)license)
{
    _license = license;
}
@end
