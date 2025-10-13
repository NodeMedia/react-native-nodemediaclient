//
//  RCTNodePlayerView.m
//
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

#import "RCTNodePlayerView.h"
#import "RCTNodeMediaClient.h"
#import <NodeMediaClient/NodeMediaClient.h>

@interface RCTNodePlayerView () <NodePlayerDelegate>

@property(strong, nonatomic) NodePlayer *np;

@end

@implementation RCTNodePlayerView

- (id)init {
  self = [super init];
  if (self) {
      _np = [[NodePlayer alloc] initWithLicense:[RCTNodeMediaClient license]];
      [_np setNodePlayerDelegate:self];
      [_np attachView:self];
  }
  return self;
}

- (void)dealloc
{
    [_np detachView];
}

-(void) onEventCallback:(nonnull id)sender event:(int)event msg:(nonnull NSString*)msg {
    if (_onChange) {
        _onChange(@{@"code": [NSNumber numberWithInteger:event], @"msg": msg});;
    }
}

- (void)setBufferTime:(int)bufferTime {
    [_np setBufferTime:bufferTime];
}

- (void)setVolume:(float)volume {
    [_np setVolume:volume];
}

- (void)setCryptoKey:(NSString *)cryptoKey {
    [_np setCryptoKey:cryptoKey];
}

- (void)setHWAccelEnable:(BOOL)HWAccelEnable {
    [_np setHWAccelEnable:HWAccelEnable];
}

- (void)setHTTPReferer:(NSString *)HTTPReferer {
    [_np setHTTPReferer:HTTPReferer];
}

- (void)setHTTPUserAgent:(NSString *)HTTPUserAgent {
    [_np setHTTPUserAgent:HTTPUserAgent];
}

- (void)setScaleMode:(int)scaleMode {
    [_np setScaleMode:scaleMode];
}

-(int)start{
    if(!_url) {
        return -1;
    }
    return [_np start:_url];
}

-(int)stop {
    return [_np stop];
}

@end
